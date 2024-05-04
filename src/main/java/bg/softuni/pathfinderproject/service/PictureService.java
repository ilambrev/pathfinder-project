package bg.softuni.pathfinderproject.service;

import bg.softuni.pathfinderproject.model.dto.PictureCreateDTO;

public interface PictureService {

    boolean addPictureToRoute(PictureCreateDTO pictureCreateDTO, Long routeId);
}