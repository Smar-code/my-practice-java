package com.naversync.naversync.model;

import lombok.Data;

@Data
public class NaverSyncResponse {
    private Long affiliateId;
    private String bookingDate;
    private String bookingStatus;
    private String bookingType;
    private String checkInDate;
    private String freeCancelDeadLine;
    private String hcHotelId;


    public NaverSyncResponse(Builder builder)
    {
        this.affiliateId = builder.affiliateId;
        this.bookingDate = builder.bookingDate;
        this.bookingStatus = builder.bookingStatus;
        this.bookingType = builder.bookingType;
        this.checkInDate = builder.checkInDate;
        this.freeCancelDeadLine = builder.freeCancelDeadLine;
        this.hcHotelId = builder.hcHotelId;
    }


    public static class Builder {
        private Long affiliateId;
        private String bookingDate;
        private String bookingStatus;
        private String bookingType;
        private String checkInDate;
        private String freeCancelDeadLine;
        private String hcHotelId;


        public Builder affiliateId(Long affiliateId) {
            this.affiliateId = affiliateId;
            return this;
        }

        public Builder bookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder bookingStatus(String bookingStatus) {
            this.bookingStatus = bookingStatus;
            return this;
        }

        public Builder bookingType(String bookingType) {
            this.bookingType = bookingType;
            return this;
        }

        public Builder checkInDate(String checkInDate) {
            this.checkInDate = checkInDate;
            return this;
        }

        public Builder freeCancelDeadLine(String freeCancelDeadLine) {
            this.freeCancelDeadLine = freeCancelDeadLine;
            return this;
        }

        public Builder hcHotelId(String hcHotelId) {
            hcHotelId = hcHotelId;
            return this;
        }

        public NaverSyncResponse build() {
            return new NaverSyncResponse(this);
        }

    }
}
