package com.codegym.casestudy_springboot.models.contract;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AttachServiceConstractKey implements Serializable {

    @Column(name = "attach_service_id")
    int attachServiceId;

    @Column(name = "constract_id")
    int constractId;
}
