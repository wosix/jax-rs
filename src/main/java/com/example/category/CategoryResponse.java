package com.example.category;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {

    @SerializedName("label")
    private String name;

    @SerializedName("url")
    private String url;

    @SerializedName("priority")
    private int priority;

    @SerializedName("subCategory")
    private List<CategoryResponse> subCategory = new ArrayList<>();

    public CategoryResponse(String name, String url, int priority) {
        this.name = name;
        this.url = url;
        this.priority = priority;
    }

    public static class CategoryResponseBuilder {
        public CategoryResponseBuilder subCategory(CategoryResponse categoryResponse) {
            if (this.subCategory == null) {
                this.subCategory = new ArrayList<>();
            }
            this.subCategory.add(categoryResponse);
            return this;
        }
    }
}
