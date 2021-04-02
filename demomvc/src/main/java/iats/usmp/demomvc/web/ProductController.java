package iats.usmp.demomvc.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;
import iats.usmp.demomvc.domain.*;
import iats.usmp.demomvc.repository.*;

@RestController
public class ProductController{
    
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> products(){
        return  new ResponseEntity<List<Product>>(
            productRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> create(@RequestBody Product p){
        productRepository.save(p);
        productRepository.flush();
        return new ResponseEntity<Integer>(p.getId(),HttpStatus.CREATED);
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> products(@PathVariable int id){
        Optional<product> optinalEntity = productRepository.findById(id);
        if(optinalEntity.isPresent())
            return new ResponseEntity<Product>(
                optinalEntity.get(), HttpStatus.OK);
        else
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable int id){
        productRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> update(@RequestBody Product p){
        create(p);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
}