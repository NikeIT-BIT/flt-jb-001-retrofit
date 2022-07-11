package com.ntarasov;

import com.ntarasov.request.AlbumRequest;
import com.ntarasov.request.AlbumUpdateRequest;
import com.ntarasov.request.PostCreateRequest;
import com.ntarasov.request.PostUpdateRequest;
import com.ntarasov.response.AlbumResponse;
import com.ntarasov.response.CommentResponse;
import com.ntarasov.response.PostResponse;
import com.ntarasov.response.UserResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JavaPlaceholderApi {

    //    ------------------------POSTS------------------------
    @GET("/posts")
    Call<List<PostResponse>> post();

    //    ------------------------POSTS CREATE------------------------
    @POST("/posts")
    Call<PostResponse> postCreate(@Body PostCreateRequest request);

    //    ------------------------POSTS UPDATE------------------------
    @PUT("/posts/{id}")
    Call<PostResponse> postUpdate(@Path("id") Integer id, @Body PostUpdateRequest request);

    //    ------------------------POSTS DELETE------------------------
    @DELETE("/posts/{id}")
    Call<Void> postDelete(@Path("id") Integer id);

    //    ------------------------POSTS WITH ID------------------------
    @GET("/posts/{id}")
    Call<PostResponse> postWithId(@Path("id") Integer id);

    //    ------------------------POSTS COMMENTS------------------------
    @GET("/posts/{id}/comments")
    Call<List<CommentResponse>> postComments(@Path("id") Integer id);

    //    ------------------------USERS RESPONSE------------------------
    @GET("/users")
    Call<List<UserResponse>> userResponse();

    //    ------------------------USER ALBUMS------------------------
    @GET("/users/{id}/albums")
    Call<List<AlbumResponse>> userAlbums(@Path("id") Integer id);

    //    ------------------------ALBUMS------------------------
    @GET("/albums")
    Call<List<AlbumResponse>> albums();

    //    ------------------------ALBUMS WITH ID------------------------
    @GET("/albums/{id}")
    Call<AlbumResponse> albumsWithId(@Path("id") Integer id);

    //------------------------ALBUM CREATE------------------------
    @POST("/albums")
    Call<AlbumResponse> albumCreate(@Body AlbumRequest request);

    //    ------------------------ALBUM UPDATE------------------------
    @PUT("/albums/{id}")
    Call<AlbumResponse> albumUpdate(@Path("id") Integer id, @Body AlbumUpdateRequest request);
    //    ------------------------ALBUM DELETE------------------------

    @DELETE("/posts/{id}")
    Call<Void> albumDelete(@Path("id") Integer id);
}
