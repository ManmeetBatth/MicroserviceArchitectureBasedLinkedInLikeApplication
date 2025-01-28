package com.Projects.LinkedIn.posts_service.auth;


public class UserContextHolder {

    public static final ThreadLocal<Long> currentUserId= new ThreadLocal<>();

    public static Long getCurrentUserId(){
        return currentUserId.get();

    }

    static void setCurrentUserId(Long userId){
        currentUserId.set(userId);
    }
    
    static void clear(){
        currentUserId.remove();
    }
}
