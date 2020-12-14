package org.acme.commandmode.controller;

import org.acme.commandmode.DTO.ResponseDTO;
import org.acme.commandmode.Service.matkulService;
import org.acme.commandmode.model.matkulModel;
import org.acme.commandmode.repository.matkulRepository;
import org.acme.commandmode.utils.ResponseEnum;
import org.acme.commandmode.utils.ResponseUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/matkul")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class matkulController {

    //CRUD Matkul
    @Inject
    matkulRepository MatkulRepository;
    @Inject
    matkulService MatkulService;

    @POST
    @Path("/add/matkul")
    @Produces("application/json")
    public Response addMatkul(matkulModel MatkulModel) {
        MatkulService.addMatkul(MatkulModel);
        return Response.ok("Matakuliah Berhasil Ditambahkan").build();
    }

    @PUT
    @Path("/matkul/{kd_matkul}")
    @Produces("application/json")
    public Response upateMatkul(@PathParam(value = "kd_matkul") Long kd_matkul, @Valid matkulModel MatkulModel) {
        if (null != MatkulRepository.findById(kd_matkul)) {
            MatkulService.addMatkul(MatkulModel);
            return Response.ok("Data : " + kd_matkul + " Berhasil Diedit").build();
        }
        return Response.serverError().build();
    }

    @GET
    @Path("/matkul")
    @Produces("application/json")
    public ResponseDTO getMatkul() {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            List<matkulModel> prod = MatkulService.getMatkul();
            responseDTO.setBody(prod);
            ResponseUtils.setResponse(responseDTO, ResponseEnum.SUCCESS);
        } catch (ValidationException ex) {
            responseDTO.setStatus(ex.getMessage());
            responseDTO.setStatusCode(501);
        } catch (Exception e) {
            responseDTO.setStatus(e.getMessage());
            responseDTO.setStatusCode(501);
        }
        return responseDTO;
    }

    @DELETE
    @Path("/matkul/{kd_matkul}")
    public Response deleteMatkul(@PathParam(value = "kd_matkul") Long kd_matkul) {
        MatkulService.deleteMatkul(kd_matkul);
        return Response.ok("Matakuliah Dengan Kode: " + kd_matkul + " Berhasil Dihapus").build();
    }
}
