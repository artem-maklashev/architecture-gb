using ClinicService.Models;
using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Swashbuckle.AspNetCore.Annotations;

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
        [SwaggerOperation(OperationId = "ClientCreate")]
        //[ProducesResponseType(typeof(int), StatusCodes.Status200OK)]
        public ActionResult<int> Create([FromBody] CreateClientRequest createClientRequest)
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
        [SwaggerOperation(OperationId = "ClientUpdate")]

        //[ProducesResponseType(typeof(int), StatusCodes.Status200OK)]
        public ActionResult<int> Update([FromBody] UpdateClientRequest updateClientRequest)
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
        [SwaggerOperation(OperationId = "ClientDelete")]
        public ActionResult<int> Delete([FromQuery] int clientId)
        {
            var client = _clientRepository.GetById(clientId);
            if (client == null)
            {
                return NotFound();
            }

            _clientRepository.Delete(clientId);
            return Ok(clientId);  
        }


        [HttpGet("get-all")]
        [SwaggerOperation(OperationId = "ClientGetAll")]

        public ActionResult<List<Client>> GetAll()
        {
            var res = _clientRepository.GetAll();
            return Ok(res);
        }

        [HttpGet("get/{clientId}")]
        [SwaggerOperation(OperationId = "ClientGetById")]

        public ActionResult<Client> GetById(int id)
        {
            return Ok(_clientRepository.GetById(id));
        }
    }
}
