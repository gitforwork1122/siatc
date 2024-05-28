package sia.tacocoud.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocoud.data.UserRepository;
import sia.tacocoud.model.Order;
import sia.tacocoud.model.User;
import sia.tacocoud.data.OrderRepository;
import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@RequestMapping("/api/orders/old")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;
    private UserRepository userRepo;

    public OrderController(OrderRepository orderRepo, UserRepository userRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus,
                               @AuthenticationPrincipal Jwt principal) {
        if(errors.hasErrors()) {
            return "orderForm";
        }
        User user = getCurrentUser(principal);
        order.setUser(user);
        log.info("Order submitted: " + order);
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }


    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal Jwt principal, Model model) {
        User user = getCurrentUser(principal);
        List<Order> orders = orderRepo.findByUserOrderByPlacedAtDesc(user);
        model.addAttribute("orders", orders);
        return "orderList";
    }

    private User getCurrentUser(Jwt principal) {
        String username = principal.getClaim("preferred_username");
        Optional<User> userOpt = Optional.ofNullable(userRepo.findByUsername(username));
        return userOpt.orElseThrow(() -> new IllegalStateException("User not found: " + username));
    }

}