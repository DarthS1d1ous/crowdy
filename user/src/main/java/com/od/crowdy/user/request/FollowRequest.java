package com.od.crowdy.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowRequest {
    private String followerUserId;
    private String followingUserId;
}
