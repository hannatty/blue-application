package br.com.devweslley.aplicand.dto;

import lombok.*;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDTO {
    private  static final long serialVersionUID= 1L;


    private long id;
    private String name;
    private String email;
    private String telefone;

}
