package com.example.tp_spring.controlleur;


import com.example.tp_spring.modele.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.example.tp_spring.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    // La page d'ouverture
    @RequestMapping
    public String welcome(){
        return "Ceci est la page d'ouverture";
    }

    // Renvoyer la liste de tous les produits
    @GetMapping("/products")
    public String listAll(Model model)
    {
        model.addAttribute("listProducts", productService.listsAll());

//        return productService.listsAll();
        return "product";
    }

    // Renvoyer le produit correspondant à l'ID donné
//    @GetMapping("/products")
//    public String getProductById(@RequestParam(name="pID", defaultValue="") Long id , Model model) {
//        Product product = productService.get(id);
//        if (product != null) {
//            model.addAttribute("listProducts", product);
//            System.out.println("==============By ID ==============");
//            return "product";
//        }
//        return "product";
//    }

    @GetMapping("/products/filter1")
    public String getBYId(@RequestParam(name="pID", defaultValue="") Long id , Model model) {
        try {
            Product product = productService.get(id);
            if (product != null) {
                model.addAttribute("listProducts", product);
                model.addAttribute("filter1", id);
                System.out.println("==============By ID ==============");
//        return clientService.get(id);
                return "product";
            }
        }catch (Exception e){
            return "product";
        }
        return "product";
    }

    @GetMapping("/products/new")
    public String showNewProductForm(Model model)
    {
        //create model attribute to bind Form data
        Product product = new Product();
        model.addAttribute("product", product);
        return "add_product";
    }
    // Ajouter un nouveau produit
    @PostMapping("/products/save")
    public String save(@ModelAttribute("product") @Valid Product product , Errors errors) {
        if (errors.hasErrors())
        {
            return "add_product";
        }
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/getForUpdate/{id}")
    public String getForUpdate(@PathVariable Long id,Model model) {

        Product product =  productService.get(id);
        model.addAttribute("product", product);
        return "update_product";
    }
    // Mettre à jour un produit existant
    @PostMapping("/products/update")
    public String update(@ModelAttribute("product") @Valid Product updateProduct) {
       Product product = productService.get(updateProduct.getId());
       if(product != null){
           product.setName(updateProduct.getName());
           product.setDescription(updateProduct.getDescription());
           product.setPrice(updateProduct.getPrice());
           productService.save(product);

       }
       return "redirect:/products";
    }

    // Supprimer le produit correspondant à l'ID donné
    @GetMapping("/products/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            productService.delete(id);
            return "redirect:/products";
        }catch (Exception e){
            return "redirect:/products";
        }
    }

    // Renvoyer le produit correspondant au nom donné (exact match)
    @GetMapping("/products/name/filter2")
    public String getByLastName(@RequestParam(name="name", defaultValue="") String name, Model model) {

        model.addAttribute("listProducts", productService.getProductByName(name));
        model.addAttribute("filter2", name);
        System.out.println("===========Find By Name==========");
        return "product";
    }

    // Renvoyer la liste de produits contenant le nom donné
    @GetMapping("/products/contain/{name}")
    public List<Product> getProductsContainingName(@PathVariable String name) {
        return productService.getProductsContainingName(name);
    }
}
