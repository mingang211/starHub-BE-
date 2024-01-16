package com.sparta.devstar_be.like;

import com.sparta.devstar_be.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/starshare/{shareId}/like")
    public ResponseEntity<LikeResponseDto> addLikeToShare(@PathVariable Long shareId,
                                                          @AuthenticationPrincipal UserDetailsImpl userDetails){
        LikeResponseDto addedLike = likeService.addLikeToShare(shareId, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(addedLike);
    }

    @DeleteMapping("/starshare/{shareId}/like")
    public ResponseEntity<LikeResponseDto> deleteLikeToShare(@PathVariable Long shareId,
                                                    @AuthenticationPrincipal UserDetailsImpl userDetails) {
        LikeResponseDto deletedLike = likeService.deleteLikeToShare(shareId, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(deletedLike);
    }
}