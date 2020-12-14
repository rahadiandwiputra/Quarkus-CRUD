package org.acme.commandmode.controller;

import org.acme.commandmode.DTO.ResponseDTO;
import org.acme.commandmode.Service.nilaiService;
import org.acme.commandmode.model.nilaiModel;
import org.acme.commandmode.repository.nilaiRepository;
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

@Path("/nilai")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class nilaiController {

    //CRUD NILAI
    @Inject
    nilaiRepository NilaiRepository;
    @Inject
    nilaiService NilaiService;

    @POST
    @Path("/add/nilai")
    @Produces("application/json")
    public Response addNilai(nilaiModel NilaiModel) {
        NilaiService.addNilai(NilaiModel);
        return Response.ok("Nilai Berhasil Ditambahkan").build();
    }

    @PUT
    @Path("/nilai/{id}")
    @Produces("application/json")
    public Response upateNilai(@PathParam(value = "id") Long id, @Valid nilaiModel NilaiModel) {
        if (null != NilaiRepository.findById(id)) {
            NilaiService.addNilai(NilaiModel);
            return Response.ok("Data : " + id + " Berhasil Diedit").build();
        }
        return Response.serverError().build();
    }

    @GET
    @Path("/nilai")
    @Produces("application/json")
    public ResponseDTO getNilai() {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            List<nilaiModel> prod = NilaiService.getNilai();
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
    @Path("/nilai/{id}")
    public Response deleteNilai(@PathParam(value = "id") Long id) {
        NilaiService.deleteNilai(id);
        return Response.ok("Data Nilai Dengan ID= " + id + "Berhasil Dihapus").build();
    }
}
