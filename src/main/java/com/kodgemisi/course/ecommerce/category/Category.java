package com.kodgemisi.course.ecommerce.category;

import com.kodgemisi.course.ecommerce.Product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    public Category(String name) { this.name = name; }


}
