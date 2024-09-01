using ClinicService.Models;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;

namespace ClinicService.Services.Impl
{
    public class ClientRepository : IClientRepository
    {
        private const string connectionString = "Server=localhost; Database=Clinic; Uid=root; Pwd=402986;";

        public int Create(Client item)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "INSERT INTO Clients(Document, SurName, FirstName, Patronymic, Birthday) VALUES (@Document, @SurName, @FirstName, @Patronymic, @Birthday)";
                cmd.Parameters.AddWithValue("@Document", item.Document);
                cmd.Parameters.AddWithValue("@SurName", item.SurName);
                cmd.Parameters.AddWithValue("@FirstName", item.FirstName);
                cmd.Parameters.AddWithValue("@Patronymic", item.Patronymic);
                cmd.Parameters.AddWithValue("@Birthday", item.Birthday.Ticks);
                cmd.Prepare();
                return cmd.ExecuteNonQuery();
            }
        }

        public int Delete(int id)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "DELETE FROM Clients WHERE ClientId = @Id";
                cmd.Parameters.AddWithValue("@Id", id);
                cmd.Prepare();
                return cmd.ExecuteNonQuery();
            }
        }

        public List<Client> GetAll()
        {
            List<Client> clients = new List<Client>();

            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "SELECT * FROM Clients";
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Client client = new Client
                        {
                            ClientId = reader.GetInt32("ClientId"),
                            Document = reader.GetString("Document"),
                            SurName = reader.GetString("SurName"),
                            FirstName = reader.GetString("FirstName"),
                            Patronymic = reader.GetString("Patronymic"),
                            Birthday = new DateTime(reader.GetInt64("Birthday"))
                        };
                        clients.Add(client);
                    }
                }
            }
            return clients;
        }

        public Client GetById(int id)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "SELECT * FROM Clients WHERE ClientId = @Id";
                cmd.Parameters.AddWithValue("@Id", id);
                cmd.Prepare();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        return new Client
                        {
                            ClientId = reader.GetInt32("ClientId"),
                            Document = reader.GetString("Document"),
                            SurName = reader.GetString("SurName"),
                            FirstName = reader.GetString("FirstName"),
                            Patronymic = reader.GetString("Patronymic"),
                            Birthday = new DateTime(reader.GetInt64("Birthday"))
                        };
                    }
                }
            }
            return null; // Клиент с таким id не найден
        }

        public int Update(Client item)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                MySqlCommand cmd = conn.CreateCommand();
                cmd.CommandText = "UPDATE Clients SET Document = @Document, SurName = @SurName, FirstName = @FirstName, Patronymic = @Patronymic, Birthday = @Birthday WHERE ClientId = @Id";
                cmd.Parameters.AddWithValue("@Document", item.Document);
                cmd.Parameters.AddWithValue("@SurName", item.SurName);
                cmd.Parameters.AddWithValue("@FirstName", item.FirstName);
                cmd.Parameters.AddWithValue("@Patronymic", item.Patronymic);
                cmd.Parameters.AddWithValue("@Birthday", item.Birthday.Ticks);
                cmd.Parameters.AddWithValue("@Id", item.ClientId);
                cmd.Prepare();
                return cmd.ExecuteNonQuery();
            }
        }
    }
}
