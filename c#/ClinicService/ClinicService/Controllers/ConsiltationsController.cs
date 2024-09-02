using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ClinicService.Controllers
{
    [Route("api/Consultations")]
    [ApiController]
    public class ConsiltationsController : ControllerBase
    { 
    private readonly IConsultationRepository _consultationRepository;

    public ConsiltationsController(IConsultationRepository consultationRepository)
    {
            _consultationRepository = consultationRepository;
    }

    [HttpGet("geConsultationById/{ConsultationId}")]
    public IActionResult GetById(int id)
    {
        return Ok(_consultationRepository.GetById(id));
    }

    [HttpGet("getAll")]
    public IActionResult GetAll()
    {
        return Ok(_consultationRepository.GetAll());
    }

    [HttpPut("update")]
    public IActionResult Update([FromBody] UpdateConsultationRequest updateConsultationRequest)
    {
        int res = _consultationRepository.Update(
            new Models.Consultation
            {
                ConsultationId = updateConsultationRequest.ConsultationId,
                PetId = updateConsultationRequest.PetId,
                ClientId = updateConsultationRequest.ClientId,
                ConsultationDate = updateConsultationRequest.ConsultationDate,
                Description = updateConsultationRequest.Description                
            });
        return Ok(res);
    }

    [HttpPost("create")]
    public IActionResult Create([FromBody] CreateConsultationRequest createConsultationRequest)
    {
        int res = _consultationRepository.Create(
            new Models.Consultation
            {
                PetId = createConsultationRequest.PetId,
                ClientId = createConsultationRequest.ClientId,
                ConsultationDate = createConsultationRequest.ConsultationDate,
                Description = createConsultationRequest.Description
            });
        return Ok(res);
    }

    [HttpDelete("delete")]
    public IActionResult DeleteById([FromQuery] int id)
    {
        int res = _consultationRepository.Delete(id);
        return Ok(res);
    }
}
}
