package com.ntarasov;

import com.ntarasov.request.PostCreateRequest;
import com.ntarasov.request.PostUpdateRequest;
import com.ntarasov.response.AlbumResponse;
import com.ntarasov.response.CommentResponse;
import com.ntarasov.response.PostResponse;
import com.ntarasov.response.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("------------------------START------------------------");

        JavaPlaceholderApi api = JsonPlaceholderService.getInstance().getJSONApi();

        System.out.println("------------------------POSTS------------------------");
        List<PostResponse> posts = api.post().execute().body();
        assert posts != null;
        System.out.println(posts.toString());

        System.out.println("------------------------POSTS CREATE------------------------");
        PostResponse postCreate = api.postCreate(PostCreateRequest.builder()
                .userId(3)
                .title("New posts")
                .body("News")
                .build()).execute().body();
        System.out.println(postCreate);

        System.out.println("------------------------POSTS UPDATE------------------------");
        PostResponse postUpdate = api.postUpdate(1, PostUpdateRequest.builder()
                .id(1)
                .userId(3)
                .title("New posts")
                .body("News")
                .build()).execute().body();
        System.out.println(postUpdate);

        System.out.println("------------------------POSTS DELETE------------------------");
        Boolean postDelete = api.postDelete(1).execute().isSuccessful();
        System.out.println(postDelete);

        System.out.println("------------------------POSTS WITH ID------------------------");
        PostResponse postWithId = api.postWithId(1).execute().body();
        System.out.println(postWithId);

        System.out.println("------------------------POSTS COMMENTS------------------------");
        List<CommentResponse> postComments = api.postComments(1).execute().body();
        System.out.println(postComments);

        System.out.println("------------------------USERS RESPONSE------------------------");
        List<UserResponse> userResponse = api.userResponse().execute().body();
        System.out.println(userResponse);

        System.out.println("------------------------USERS ALBUMS------------------------");
        List<AlbumResponse> userAlbums = api.userAlbums(1).execute().body();
        System.out.println(userAlbums);


        Call<List<CommentResponse>> commentsCall = api.postComments(1);
        Response<List<CommentResponse>> commentsCallResponse = commentsCall.execute();
        if (commentsCallResponse.isSuccessful() && commentsCallResponse.code() == 200) {
            List<CommentResponse> responses = commentsCallResponse.body();
        } else {
            if (commentsCallResponse.code() == 400) {
                String error = commentsCallResponse.errorBody().string();
            } else if (commentsCallResponse.code() == 500) {
                String error = commentsCallResponse.errorBody().string();
            } else if (commentsCallResponse.code() == 403) {
                String error = commentsCallResponse.errorBody().string();
            }
        }
        api.postComments(1).enqueue(new Callback<List<CommentResponse>>(){
            @Override
            public void onResponse(Call<List<CommentResponse>> call, Response<List<CommentResponse>> response) {
                List<CommentResponse> commentAsyncResponses = response.body();
            }

            @Override
            public void onFailure(Call<List<CommentResponse>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}