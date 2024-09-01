using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ClinicService.Controllers
{
    [Route("api/Client")]
    [ApiController]
    public class ClientController : ControllerBase

    {
        private readonly IClientRepository _clientRepository;
        public ClientController(IClientRepository clientRepository) 
        {
            _clientRepository = clientRepository;
        }

        [HttpPost("create")]
        //[ProducesResponseType(typeof(int), StatusCodes.Status200OK)]
        public IActionResult Create([FromBody] CreateClientRequest createClientRequest)
        {
            int res = _clientRepository.Create(
                new Models.Client
                {
                    Document = createClientRequest.Document,
                    SurName = createClientRequest.SurName,
                    FirstName = createClientRequest.FirstName,
                    Patronymic = createClientRequest.Patronymic,
                    Birthday = createClientRequest.Birthday,
                });
            return Ok(res);
        }


        [HttpPut("update")]
        //[ProducesResponseType(typeof(int), StatusCodes.Status200OK)]
        public IActionResult Update([FromBody] UpdateClientRequest updateClientRequest)
        {
            int res = _clientRepository.Update(
                new Models.Client
                {
                    ClientId = updateClientRequest.ClientId,
                    Document = updateClientRequest.Document,
                    SurName = updateClientRequest.SurName,
                    FirstName = updateClientRequest.FirstName,
                    Patronymic = updateClientRequest.Patronymic,
                    Birthday = updateClientRequest.Birthday,
                });
            return Ok(res);
        }

        [HttpDelete("delete")]
        public IActionResult Delete([FromQuery] int clientId)
        {
            int res = _clientRepository.Delete(clientId);
            return Ok(res);
        }

        [HttpGet("get-all")]
        public IActionResult GetAll()
        {
            var res = _clientRepository.GetAll();
            return Ok(res);
        }

        [HttpGet("get/{clientId}")]
        public IActionResult GetById(int id)
        {
            return Ok(_clientRepository.GetById(id));
        }
    }
}
