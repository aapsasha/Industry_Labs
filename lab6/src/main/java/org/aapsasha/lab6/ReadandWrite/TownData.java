package org.aapsasha.lab6.ReadandWrite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TownData {
    private String firstTown;
    private String secondTown;
    private int distance;
}