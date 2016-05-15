package org.game.sudoku;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sudoku extends ResourceSupport {

    private final Integer number;
    private final Integer position;
    
    @JsonCreator
    public Sudoku(@JsonProperty("number") Integer number,
    		@JsonProperty("position") Integer position) {
        this.number = number;
        this.position = position;
    }

	public Integer getNumber() {
		return number;
	}

	public Integer getPosition() {
		return position;
	}

}