using ClinicService.Models;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;

namespace ClinicService.Services.Impl
{
    public class PetRepository : IPetRepository
    {
        private const string connectionString = "Server=localhost; Database=Clinic; Uid=root; Pwd=402986;";

        public int Create(Pet item)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                using (MySqlCommand cmd = conn.CreateCommand())
                {
                    cmd.CommandText = "INSERT INTO Pets (ClientId, Name, Birthday) VALUES (@ClientId, @Name, @Birthday)";
                    cmd.Parameters.AddWithValue("@ClientId", item.ClientId);
                    cmd.Parameters.AddWithValue("@Name", item.Name);
                    cmd.Parameters.AddWithValue("@Birthday", item.Birthday.Ticks);
                    cmd.Prepare();
                    cmd.ExecuteNonQuery();

                    // Get the last inserted ID
                    cmd.CommandText = "SELECT LAST_INSERT_ID()";
                    return Convert.ToInt32(cmd.ExecuteScalar());
                }
            }
        }

        public int Delete(int id)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                using (MySqlCommand cmd = conn.CreateCommand())
                {
                    cmd.CommandText = "DELETE FROM Pets WHERE PetId = @Id";
                    cmd.Parameters.AddWithValue("@Id", id);
                    cmd.Prepare();
                    return cmd.ExecuteNonQuery();
                }
            }
        }

        public List<Pet> GetAll()
        {
            List<Pet> pets = new List<Pet>();

            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                using (MySqlCommand cmd = conn.CreateCommand())
                {
                    cmd.CommandText = "SELECT * FROM Pets";
                    using (MySqlDataReader reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            Pet pet = new Pet
                            {
                                ClientId = reader.GetInt32("ClientId"),
                                PetId = reader.GetInt32("PetId"),
                                Name = reader.GetString("Name"),
                                Birthday = new DateTime(reader.GetInt64("Birthday"))
                            };
                            pets.Add(pet);
                        }
                    }
                }
            }
            return pets;
        }

        public Pet GetById(int id)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                using (MySqlCommand cmd = conn.CreateCommand())
                {
                    cmd.CommandText = "SELECT * FROM Pets WHERE PetId = @Id";
                    cmd.Parameters.AddWithValue("@Id", id);
                    cmd.Prepare();
                    using (MySqlDataReader reader = cmd.ExecuteReader())
                    {
                        if (reader.Read())
                        {
                            return new Pet
                            {
                                ClientId = reader.GetInt32("ClientId"),
                                PetId = reader.GetInt32("PetId"),
                                Name = reader.GetString("Name"),
                                Birthday = new DateTime(reader.GetInt64("Birthday"))
                            };
                        }
                    }
                }
            }
            return null; // Pet with the specified id not found
        }

        public int Update(Pet item)
        {
            using (MySqlConnection conn = new MySqlConnection(connectionString))
            {
                conn.Open();
                using (MySqlCommand cmd = conn.CreateCommand())
                {
                    cmd.CommandText = "UPDATE Pets SET Name = @Name, ClientId = @ClientId, Birthday = @Birthday WHERE PetId = @PetId";
                    cmd.Parameters.AddWithValue("@Name", item.Name);
                    cmd.Parameters.AddWithValue("@PetId", item.PetId);  // Corrected parameter name
                    cmd.Parameters.AddWithValue("@ClientId", item.ClientId);  // Corrected parameter name
                    cmd.Parameters.AddWithValue("@Birthday", item.Birthday.Ticks);
                    cmd.Prepare();
                    return cmd.ExecuteNonQuery();
                }
            }
        }
    }
}
