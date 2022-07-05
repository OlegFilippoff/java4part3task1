package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class Player {
    private int playerId;
    private String playerName;
    private int playerStrength;

}
