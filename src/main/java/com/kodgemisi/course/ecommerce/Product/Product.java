package com.kodgemisi.course.ecommerce.Product;

import com.kodgemisi.course.ecommerce.category.Category;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;

    private String description;

    @Min(0)
    @NotNull
    private BigDecimal price;

    @Min(0)
    @NotNull
    private int stock;

    @Pattern(regexp = "^http.*")
    private String url;

    @OneToOne
    private Category category;

    private LocalDate creationDate;
}
