package com.luiz.erp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "in_pf")
    private Boolean inPf;

    @Column(name = "nr_cpf")
    private String nrCpf;

    @Column(name = "nr_cnpj")
    private String nrCnpj;

    @Column(name = "tx_nome")
    private String txNmCliente;

    @Column(name = "tx_razao_social")
    private String txNmRazaoSocial;

    @Column(name = "sexo")
    private String inSexoMasc;

    // getters e setters
    
    
    
}