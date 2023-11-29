package com.example.category;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("bar")
public class CategoryService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories(){
        CategoryResponse response = createMenusResponse();

        return Response.ok(new Gson().toJson(response)).build();
    }

    private CategoryResponse createMenusResponse() {
        return CategoryResponse.builder()
                .name("menubar")
                .url("menu_url")
                .priority(1)
                .subCategory(
                        CategoryResponse.builder()
                                .name("sub_menu")
                                .url("sub_menu_url")
                                .priority(1)
                                .subCategory(
                                        CategoryResponse.builder()
                                                .name("sub_sub_menu")
                                                .url("sub_sub_menu_url")
                                                .priority(1)
                                                .build()
                                ).subCategory(
                                        CategoryResponse.builder()
                                                .name("sub_sub_menuuuu")
                                                .url("sub_sub_menu_url")
                                                .priority(6)
                                                .build()
                                )
                                .build()
                ).build();
    }
}
