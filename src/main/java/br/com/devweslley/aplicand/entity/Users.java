package br.com.devweslley.aplicand.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serial;
import java.io.Serializable;

@Entity(name = "users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Users implements Serializable {
    private  static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String telefone;





}
