package com.example.pet.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetStorePet {

    private Long id;
    private Category category;
    private String name;
    @Builder.Default
    private List<String> photoUrls = new ArrayList<>();
    @Builder.Default
    private List<Tag> tags = new ArrayList<>();
    private String status;
    
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Category {
        private Long id;
        private String name;

        public Category() {
        }

        public Category(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Tag {
        private Long id;
        private String name;

        public Tag() {
        }

        public Tag(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
