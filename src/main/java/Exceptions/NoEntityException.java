package Exceptions;

import java.sql.SQLException;

public class NoEntityException extends SQLException {
    private Long id;

    public NoEntityException(Long id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "NoEntityException{" +
                "People with id= " + id + " is not exist" +
                '}';
    }
}
