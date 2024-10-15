package com.IJSE.POS_Spring.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stock {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Long quantity;

    private String transctype;

    private LocalDateTime orderDateTime;


    @PrePersist
    protected void onCreate(){
        if(this.orderDateTime==null){
            this.orderDateTime=LocalDateTime.now();
        }
    }

}
