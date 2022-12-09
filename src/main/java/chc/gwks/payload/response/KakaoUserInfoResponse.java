package chc.gwks.payload.response;

import lombok.Data;

@Data
public class KakaoUserInfoResponse {
    @Override
    public String toString() {
        return "KakaoUserInfoResponse{" +
                "id=" + id +
                ", connected_at='" + connected_at + '\'' +
                ", properties=" + properties.toString() +
                ", kakao_account=" + kakao_account.toString() +
                '}';
    }

    private Long id;

    private String connected_at;

    private KakaoProperties properties;

    private KakaoAccount kakao_account;


    public class KakaoProperties {
        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public String getThumbnail_image() {
            return thumbnail_image;
        }

        public void setThumbnail_image(String thumbnail_image) {
            this.thumbnail_image = thumbnail_image;
        }

        private String profile_image;

        private String thumbnail_image;

        @Override
        public String toString() {
            return "KakaoProperties{" +
                    "profile_image='" + profile_image + '\'' +
                    ", thumbnail_image='" + thumbnail_image + '\'' +
                    '}';
        }
    }
    public class KakaoAccount {
        @Override
        public String toString() {
            return "KakaoAccount{" +
                    "profile_image_needs_agreement='" + profile_image_needs_agreement + '\'' +
                    ", has_email=" + has_email +
                    ", email_needs_agreement=" + email_needs_agreement +
                    ", is_email_valid=" + is_email_valid +
                    ", is_email_verified=" + is_email_verified +
                    ", email='" + email + '\'' +
                    '}';
        }

        public String getProfile_image_needs_agreement() {
            return profile_image_needs_agreement;
        }

        public void setProfile_image_needs_agreement(String profile_image_needs_agreement) {
            this.profile_image_needs_agreement = profile_image_needs_agreement;
        }

        public Boolean getHas_email() {
            return has_email;
        }

        public void setHas_email(Boolean has_email) {
            this.has_email = has_email;
        }

        public Boolean getEmail_needs_agreement() {
            return email_needs_agreement;
        }

        public void setEmail_needs_agreement(Boolean email_needs_agreement) {
            this.email_needs_agreement = email_needs_agreement;
        }

        public Boolean getIs_email_valid() {
            return is_email_valid;
        }

        public void setIs_email_valid(Boolean is_email_valid) {
            this.is_email_valid = is_email_valid;
        }

        public Boolean getIs_email_verified() {
            return is_email_verified;
        }

        public void setIs_email_verified(Boolean is_email_verified) {
            this.is_email_verified = is_email_verified;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        private String profile_image_needs_agreement;

        private Boolean has_email;

        private Boolean email_needs_agreement;

        private Boolean is_email_valid;

        private Boolean is_email_verified;

        private String email;

    }
}
