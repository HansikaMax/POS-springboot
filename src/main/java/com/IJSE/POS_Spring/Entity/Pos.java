package com.IJSE.POS_Spring.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pos {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private Double totalPrice;

    private LocalDateTime orderDateTime;

    @ManyToMany
    @JoinTable(
        name="pos_item",
        joinColumns=@JoinColumn(name="posId"),
        inverseJoinColumns=@JoinColumn(name="itemId")
    )
    private List<Item> posItems;


    @PrePersist
    protected void onCreate(){
        if(this.orderDateTime==null){
            this.orderDateTime=LocalDateTime.now();
        }
    }

}
