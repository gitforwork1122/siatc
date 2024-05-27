package sia.tacocoud.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocoud.model.Order;
import sia.tacocoud.model.User;
import sia.tacocoud.data.OrderRepository;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/api/old/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        if(errors.hasErrors()) {
            return "orderForm";
        }
        order.setUser(user);
        log.info("Order submitted: " + order);
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model) {
        List<Order> orders = orderRepo.findByUserOrderByPlacedAtDesc(user);
        model.addAttribute("orders", orders);
        return "orderList";
    }

}