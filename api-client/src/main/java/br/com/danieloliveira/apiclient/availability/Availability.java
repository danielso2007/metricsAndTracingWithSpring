package br.com.danieloliveira.apiclient.availability;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Availability {
    private boolean available;
    private String console;
}
