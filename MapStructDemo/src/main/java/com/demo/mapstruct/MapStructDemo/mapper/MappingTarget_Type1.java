package com.demo.mapstruct.MapStructDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public class MappingTarget_Type1 {

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

        // Mapping method to update an existing entity
        void updateEntity(@org.mapstruct.MappingTarget EmployeeEntity entity, EmployeeDTO dto);
    }

    public static void main(String[] args) {
        // Create an instance of the mapper
        EmployeeMapper mapper = EmployeeMapper.INSTANCE;

        // Existing entity object
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId("123"); // Existing ID in the entity
        entity.setName("Old Name");
        entity.setDepartment("Old Department");
        entity.setSalary(0.0);

        // New data from DTO
        EmployeeDTO dto = new EmployeeDTO();
        dto.setName("John Doe");
        dto.setDepartment("Engineering");
        dto.setSalary(75000.0);

        // Update the existing entity with data from DTO
        mapper.updateEntity(entity, dto);

        // Output updated entity
        System.out.println("Updated Entity:");
        System.out.println("ID: " + entity.getId());
        System.out.println("Name: " + entity.getName());
        System.out.println("Department: " + entity.getDepartment());
        System.out.println("Salary: " + entity.getSalary());
    }
}
