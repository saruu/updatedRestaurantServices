package com.himal.malla.himal.Enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
    private String name;
    private String phone;
    private String address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Order> orderList;
}
