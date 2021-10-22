package com.codegym.casestudy_springboot.models.contract;

import javax.persistence.*;

@Entity
public class AttachServiceConstract {

    @EmbeddedId
    private AttachServiceConstractKey id;

    @ManyToOne
    @MapsId("attachServiceId")
    @JoinColumn(name = "attachServiceId")
    private AttachService attachService;;

    @ManyToOne
    @MapsId("constractId")
    @JoinColumn(name = "constractId")
    private Contract contract;;

    private int quantity;
}
