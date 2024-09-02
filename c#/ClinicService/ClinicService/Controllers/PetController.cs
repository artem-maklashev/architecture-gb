using ClinicService.Models.Requests;
using ClinicService.Services;
using ClinicService.Services.Impl;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace ClinicService.Controllers
{
    [Route("api/Pets")]
    [ApiController]
    public class PetController : ControllerBase
    {
        private readonly IPetRepository _petRepository;

        public PetController(IPetRepository petRepository)
        {
            _petRepository = petRepository;
        }

        [HttpGet("getPetById/{PetId}")]
        public IActionResult GetById(int id)
        {
            return Ok(_petRepository.GetById(id));
        }

        [HttpGet("getAll")]
        public IActionResult GetAll()
        {
            return Ok(_petRepository.GetAll());
        }

        [HttpPut("update")]
        public IActionResult Update([FromBody] UpdatePetRequest updatePet)
        {
            int res = _petRepository.Update(
                new Models.Pet
                {
                    PetId = updatePet.PetId,
                    ClientId = updatePet.ClientId,                    
                    Name = updatePet.Name,                    
                    Birthday = updatePet.Birthday,
                });
            return Ok(res);
        }

        [HttpPost("create")]
        public IActionResult Create([FromBody] CreatePetRequest createPet)
        {
            int res = _petRepository.Create(
                new Models.Pet
                {
                    ClientId = createPet.ClientId,
                    Name = createPet.Name,
                    Birthday = createPet.Birthday
                });
            return Ok(res);
        }

        [HttpDelete("delete")]
        public IActionResult DeleteById([FromQuery] int id)
        {
            int res = _petRepository.Delete(id);
            return Ok(res);
        }
    }
}
