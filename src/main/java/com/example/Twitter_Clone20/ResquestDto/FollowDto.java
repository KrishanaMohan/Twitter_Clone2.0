package com.example.Twitter_Clone20.ResquestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowDto {
    private String followBy;
    private String followTo;
}
