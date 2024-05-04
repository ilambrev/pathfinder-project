package bg.softuni.pathfinderproject.model.dto;

public class PictureCreateDTO {

    private String pictureUrl;

    public PictureCreateDTO() {

    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public PictureCreateDTO setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}