package org.acme.commandmode.controller;

import org.acme.commandmode.DTO.ResponseDTO;
import org.acme.commandmode.Service.prodiService;
import org.acme.commandmode.model.prodiModel;
import org.acme.commandmode.repository.prodiRepository;
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

@Path("/prodi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class prodiController {


    //CRUD Prodi
    @Inject
    prodiService ProdiService;
    @Inject
    prodiRepository ProdiRepository;

    @POST
    @Path("/add/prodi")
    @Produces("application/json")
    public Response addProdi(prodiModel ProdiModel) {
        ProdiService.addProdi(ProdiModel);
        return Response.ok("Program Studi Berhasil Ditambahkan").build();
    }

    @PUT
    @Path("/prodi/{kd_prodi}")
    @Produces("application/json")
    public Response updateProdi(@PathParam(value = "kd_prodi") Long kd_prodi, @Valid prodiModel ProdiModel) {
        if (null != ProdiRepository.findById(kd_prodi)) {
            ProdiService.addProdi(ProdiModel);
            return Response.ok("Data : " + kd_prodi + " Berhasil Diedit").build();
        }
        return Response.serverError().build();
    }

    @GET
    @Path("/prodi")
    @Produces("application/json")
    public ResponseDTO getProdi() {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            List<prodiModel> prod = ProdiService.getProdi();
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
    @Path("/prodi/{kd_prodi}")
    public Response deleteProdi(@PathParam(value = "kd_prodi") Long kd_prodi) {

        ProdiService.deleteProdi(kd_prodi);
        return Response.ok("Program Studi " + kd_prodi + " Berhasil Dihapus").build();
    }
}
