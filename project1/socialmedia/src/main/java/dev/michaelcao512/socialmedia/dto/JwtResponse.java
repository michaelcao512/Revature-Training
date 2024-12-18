package dev.michaelcao512.socialmedia.dto;

public record JwtResponse(String accessToken, Long accountId, String username, String email) {
}