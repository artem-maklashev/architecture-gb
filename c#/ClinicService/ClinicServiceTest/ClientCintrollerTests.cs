using ClinicService.Controllers;
using ClinicService.Models;
using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Mvc;
using Moq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClinicServiceTest
{
    public class ClientCintrollerTests
    {
        private ClientController _controller;
        private Mock<IClientRepository> _mockClientRepository;

        public ClientCintrollerTests() {
            _mockClientRepository = new Mock<IClientRepository>();
            _controller = new ClientController(_mockClientRepository.Object);
        }

        [Fact]
        public void GetAllClientsTest()
        {
            // [1] Подготовка данных для тестирования

            List<Client> list = new List<Client>();
            list.Add(new Client());
            list.Add(new Client());
            list.Add(new Client());

            _mockClientRepository.Setup(repository =>
            repository.GetAll()).Returns(list);

            // [2] Исполнение тестируемого метода
            var operationResult = _controller.GetAll();

            // [3] Подготовка эталонного результата и проверка результатов
            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<List<Client>>(((OkObjectResult)operationResult.Result).Value);

            _mockClientRepository.Verify(repository => repository.GetAll(), Times.Once());
        }

        public static readonly object[][] CorrectCreateClientData =
            {
            new object[] {new DateTime(1985, 5, 20), "FFF", "Иванов", "Иван", "Иванович" },
            new object[] {new DateTime(1985, 2, 10), "AAA", "Иванов", "Иван", "Иванович" },
            new object[] {new DateTime(1985, 11, 5), "CCC", "Иванов", "Иван", "Иванович" }
            };

        [Theory]
        [MemberData(nameof(CorrectCreateClientData))]
        public void CreateClientTest(DateTime birthday, string doument, string surName, string firstName, string patronymic)
        {
            _mockClientRepository.Setup(repository => repository.Create(It.IsNotNull<Client>())).Returns(1).Verifiable();
          
            var operationResult = _controller.Create(new CreateClientRequest
            {
                Birthday = birthday,
                Document = doument,
                SurName = surName,
                FirstName = firstName,
                Patronymic = patronymic
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mockClientRepository.Verify(repository => repository.Create(It.IsNotNull<Client>()), Times.Once());
        }

        [Fact]
        public void GetClientByIdTest()
        {
            Client client = new Client();
            client.ClientId = 1;
            _mockClientRepository.Setup(repository => repository.GetById(1)).Returns(client);

            var operationResult = _controller.GetById(1);

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<Client>(((OkObjectResult)operationResult.Result).Value);
            _mockClientRepository.Verify(repository => repository.GetById(1), Times.Once());
        }

        [Fact]
        public void ClientUpdateTest()
        {
            Client client = new Client();
            client.ClientId = 1;
            _mockClientRepository.Setup(repository => repository.GetById(1)).Returns(client);

            string newFirstName = "NewName";

            UpdateClientRequest updatedClient = new UpdateClientRequest
                { 
                ClientId = 1,
                FirstName = newFirstName,
                SurName = "",
                Birthday = DateTime.Now,
                Patronymic = "",
                Document = ""};

            var operationResult = _controller.Update(updatedClient);

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mockClientRepository.Verify(repository => repository.Update(It.IsNotNull<Client>()), Times.Once());
            _mockClientRepository.Verify(repository => repository.Update(It.Is<Client>(c => c.ClientId == 1 && c.FirstName == newFirstName)), Times.Once());
        }

        [Fact]
        public void ClientDeleteTest()
        {
             
            int clientId = 1;
            Client client = new Client { ClientId = clientId };

            _mockClientRepository.Setup(repository => repository.GetById(clientId)).Returns(client);

            var operationResult = _controller.Delete(clientId);

            Assert.IsType<OkObjectResult>(operationResult.Result);

            _mockClientRepository.Verify(repository => repository.Delete(1), Times.Once());
            
        }

        [Fact]
        public void ClientDelete_NotFoundTest()
        {
            int clientId = 1;

            _mockClientRepository.Setup(repository => repository.GetById(clientId)).Returns((Client)null);

            var operationResult = _controller.Delete(clientId);

            Assert.IsType<NotFoundResult>(operationResult.Result);

            _mockClientRepository.Verify(repository => repository.Delete(It.IsAny<int>()), Times.Never());

            _mockClientRepository.Verify(repository => repository.GetById(clientId), Times.Once());
        }

    }
}
