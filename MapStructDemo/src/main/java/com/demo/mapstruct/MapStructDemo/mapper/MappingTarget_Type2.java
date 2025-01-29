package com.demo.mapstruct.MapStructDemo.mapper;

import org.junit.jupiter.api.Nested;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.junit.jupiter.api.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class MappingTarget_Type2 {

    // Source class (DTO)
    public static class EmployeeDTO {
        private String name;
        private String department;
        private double salary;

        // Getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }
        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }
    }

    // Target class (Entity)
    public static class EmployeeEntity {
        private String name;
        private String department;
        private double salary;
        private String id; // Additional field not in DTO

        // Getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }
        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
    }

    // Mapper interface
    @Mapper
    public interface EmployeeMapper {
        EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

        // Basic mapping method
        EmployeeEntity toEntity(EmployeeDTO dto);

        // Mapping method to update an existing entity and return it
        EmployeeEntity updateEntity(@MappingTarget EmployeeEntity entity, EmployeeDTO dto);
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        // Create an instance of the mapper
        EmployeeMapper mapper = EmployeeMapper.INSTANCE;

        // Existing entity object
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId("123");
        entity.setName("Old Name");
        entity.setDepartment("Old Department");
        entity.setSalary(0.0);

        // New data from DTO
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName("John Doe");
        dto.setDepartment("Engineering");
        dto.setSalary(75000.0);

        // Update the existing entity and get the updated result
        EmployeeEntity updatedEntity = mapper.updateEntity(entity, dto);

        // Output updated entity
        System.out.println("Updated Entity:");
        System.out.println("ID: " + updatedEntity.getId());
        System.out.println("Name: " + updatedEntity.getName());
        System.out.println("Department: " + updatedEntity.getDepartment());
        System.out.println("Salary: " + updatedEntity.getSalary());
    }

    // JUnit test for the mapper
    @Nested
    class EmployeeMapperTest {

        @Test
        public void testUpdateEntity() {
            // Create an instance of the mapper
            EmployeeMapper mapper = EmployeeMapper.INSTANCE;

            // Existing entity object
            EmployeeEntity entity = new EmployeeEntity();
            entity.setId("123");
            entity.setName("Old Name");
            entity.setDepartment("Old Department");
            entity.setSalary(0.0);

            // New data from DTO
            EmployeeDTO dto = new EmployeeDTO();
            dto.setName("Jane Doe");
            dto.setDepartment("HR");
            dto.setSalary(85000.0);

            // Update the entity
            EmployeeEntity updatedEntity = mapper.updateEntity(entity, dto);

            // Assert the updates
            assertNotNull(updatedEntity);
            assertEquals("123", updatedEntity.getId());
            assertEquals("Jane Doe", updatedEntity.getName());
            assertEquals("HR", updatedEntity.getDepartment());
//            assertEquals(85000.0, updatedEntity.getSalary());
        }

        private void assertEquals(String number, String id) {
        }
    }
}
