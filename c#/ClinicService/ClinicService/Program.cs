
using ClinicService.Services;
using ClinicService.Services.Impl;
using MySql.Data.MySqlClient;

namespace ClinicService
{
    public class Program
    {
        public static void Main(string[] args)
        {

            //ConfigureMySqlConnection();


            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddScoped<IClientRepository, ClientRepository>();
            builder.Services.AddScoped<IPetRepository, PetRepository>();
            builder.Services.AddScoped<IConsultationRepository, ConsultationRepository>();

            builder.Services.AddControllers();

            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen();


            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseAuthorization();


            app.MapControllers();

            app.Run();
        }

        private static void ConfigureMySqlConnection()
        {
            const string connectionString = "Server=localhost; Database=Clinic; Uid=root; Pwd=402986;";
            MySqlConnection connection = new MySqlConnection(connectionString);
            connection.Open();
            PrepareSchema(connection);
        }

        private static void PrepareSchema(MySqlConnection connection)
        {
            MySqlCommand cmd = connection.CreateCommand();

            cmd.CommandText = "DROP TABLE IF EXISTS Consultations";
            cmd.ExecuteNonQuery();

            //cmd.CommandText = "DROP TABLE IF EXISTS Pets";
            //cmd.ExecuteNonQuery();

            //cmd.CommandText = "DROP TABLE IF EXISTS Clients";
            //cmd.ExecuteNonQuery();

            //cmd.CommandText =
            //    @"CREATE TABLE Clients(CLientId INTEGER AUTO_INCREMENT PRIMARY KEY,
            //    Document TEXT,
            //    SurName TEXT,                
            //    FirstName TEXT,
            //    Patronymic TEXT,
            //    Birthday BIGINT)";
            //cmd.ExecuteNonQuery();
            cmd.CommandText =
                @"CREATE TABLE Consultations(ConsultationId INTEGER AUTO_INCREMENT PRIMARY KEY,
                ClientID INTEGER,
                PetId INTEGER,
                ConsultationDate BIGINT,
                Description TEXT)";
            cmd.ExecuteNonQuery();
            //cmd.CommandText =
            //    @"CREATE TABLE Pets(PetID INTEGER AUTO_INCREMENT PRIMARY KEY,
            //    ClientID INTEGER,
            //    Name TEXT,
            //    Birthday BIGINT)";
            //cmd.ExecuteNonQuery();
        }
    }
}
