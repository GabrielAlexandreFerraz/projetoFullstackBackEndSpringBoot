package io.github.vendasApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(name ="forma_pagamento")
    private FormaPagamento formaPagamento;

    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itens;

    @Column
    private BigDecimal total;

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", formaPagamento=" + formaPagamento +
                ", itens=" + itens +
                ", total=" + total +
                '}';
    }
}