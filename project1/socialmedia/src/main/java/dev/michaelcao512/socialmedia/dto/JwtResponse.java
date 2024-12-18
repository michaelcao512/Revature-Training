package dev.michaelcao512.socialmedia.dto;

public record JwtResponse(String jwt, Long accountId, String username, String email) {
}