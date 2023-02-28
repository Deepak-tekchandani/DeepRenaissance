package com.example.tp_spring.controlleur;

import com.example.tp_spring.modele.Client;
import com.example.tp_spring.modele.Order;
import com.example.tp_spring.repository.OrderRepository;
import com.example.tp_spring.service.ClientService;
import com.example.tp_spring.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    // Récupère la liste de toutes les commandes
    @GetMapping("/orders")
    public String list(Model model)
    {
        model.addAttribute("listOrder", orderService.listsAll());

//        orderService.listsAll();
        return "order";
//        return "reservations";
    }
    @GetMapping("/orders/new")
    public String showNewOrderForm(Model model)
    {
        //create model attribute to bind Form data
        Order order = new Order();
        model.addAttribute("order", order);
        model.addAttribute("clientsList",clientService.listsAll());
        return "add_order";
    }

    // Crée une nouvelle commande
    @PostMapping("/orders/save")
    public String create(@ModelAttribute("order") @Valid Order order , Errors errors) {
        if (errors.hasErrors())
        {
            return "add_order";
        }
        orderService.save(order);
        return "redirect:/orders";
    }

    // Récupère une commande par ID
    @GetMapping("/orders/{id}")
    public Order get(@PathVariable Long id ,Model model) {

      return orderService.get(id);
    }
    @GetMapping("/orders/filter1")
    public String getBYId(@RequestParam(name="oID", defaultValue="") Long id , Model model) {
        try {
            Order order = orderService.get(id);
            if (order != null) {
                model.addAttribute("listOrder",order);
                model.addAttribute("filter1", id);
                System.out.println("==============By ID ==============");
                return "order";
            }
        }catch (Exception e){
            return "order";
        }
        return "order";
    }
    @GetMapping("/orders/getForUpdate/{id}")
    public String getForUpdate(@PathVariable Long id ,Model model) {

        Order order =  orderService.get(id);
        model.addAttribute("order", order);
        model.addAttribute("clientsList",clientService.listsAll());
        return "update_order";
    }

    // Met à jour une commande existante par ID
    @PostMapping("/orders/update")
    public String update(@ModelAttribute("order") @Valid Order updatedOrder) {
        // Récupère la commande existante
        Order existingOrder = orderService.get(updatedOrder.getId());
        if (existingOrder != null) {
            // Met à jour les informations de la commande existante
            existingOrder.setOrderNumber(updatedOrder.getOrderNumber());
            existingOrder.setClient(updatedOrder.getClient());
            // Enregistre la commande mise à jour
            orderService.save(existingOrder);
        }
        return "redirect:/orders";
    }

    // Supprime une commande par ID
    @GetMapping("/orders/delete/{id}")
    public String delete(@PathVariable Long id) {
        orderService.delete(id);
        return "redirect:/orders";
    }

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/clients/{clientId}/orders")
    public List<Order> getOrdersByClient(@PathVariable Long clientId) {
        Client client = new Client();
        client.setId(clientId);
        return orderService.findByClient(client);
    }

}