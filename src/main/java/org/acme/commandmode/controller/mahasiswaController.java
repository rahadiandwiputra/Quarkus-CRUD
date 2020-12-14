package org.acme.commandmode.controller;

import org.acme.commandmode.DTO.ResponseDTO;
import org.acme.commandmode.Service.mahasiswaService;
import org.acme.commandmode.model.mahasiswaModel;
import org.acme.commandmode.repository.mahasiswaRepository;
import org.acme.commandmode.utils.ResponseEnum;
import org.acme.commandmode.utils.ResponseUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/mahasiswa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class mahasiswaController {
    @Inject
    mahasiswaService MahasiswaService;
    @Inject
    mahasiswaRepository MahasiswaRepository;



    @GET
    @Path("/{kelas}/group")
    public Map<BigInteger, String> groupBy(@PathParam(value = "kelas") String kelas){
        List<Object[]> result=MahasiswaService.groupBy(kelas);
        Map<BigInteger, String> map = null;
        if (result != null && !result.isEmpty()) {
            map = new HashMap<BigInteger, String>();
            for (Object[] object : result) {
                map.put(((BigInteger) object[0]), (String) object[1]);
            }
        }
        return map;
    }
    //CRUD MAHASISWA
    //Save
    @POST
    @Path("/add/mahasiswa")
    @Produces("application/json")
    public Response addMahasiswa(mahasiswaModel MahasiswaModel) {
        MahasiswaService.addMahasiswa(MahasiswaModel);
        return Response.ok("Data Berhasil Ditambahkan").build();
    }

    //Edit
    @PUT
    @Path("/mahasiswa/{nim}")
    @Produces("application/json")
    public Response upateMahasiswa(@PathParam(value = "nim") Long nim, @Valid mahasiswaModel MahasiswaModel) {

        if (null != MahasiswaRepository.findById(nim)) {
            MahasiswaService.addMahasiswa(MahasiswaModel);
            return Response.ok("Data Berhasil di Edit").build();
        }
        return Response.serverError().build();
    }

    //Show data Mahasiswa
    @GET
    @Path("/mahasiswa")
    @Produces("application/json")
    public ResponseDTO getMahasiswa() {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            List<mahasiswaModel> prod = MahasiswaService.getMahasiswa();
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

    //Delete Data Mahasiswa
    @DELETE
    @Path("/mahasiswa/{nim}")
    public Response deleteMahasiswa(@PathParam(value = "nim") Long nim) {
        MahasiswaService.deleteMahasiswa(nim);
        return Response.ok("Data " + nim + " Berhasil Dihapus").build();
    }


}
