package org.example;

import java.util.List;

public class TableService {
    private final TableRepository repository;

    public TableService(TableRepository repository) {
        this.repository = repository;
    }

    public int getTableCapacity(int id) {
        Table table = repository.findById(id);
        if (table == null) {
            throw new IllegalArgumentException("Table not found with id: " + id);
        }
        return table.getCapacity();
    }

    public Table getLargestTable() {
        List<Table> tables = repository.findAll();
        if (tables == null || tables.isEmpty()) {
            throw new IllegalArgumentException("No tables found in repository");
        }
        Table largest = tables.getFirst();
        for (Table t : tables) {
            if (t.area() > largest.area()) {
                largest = t;
            }
        }
        return largest;
    }

}
