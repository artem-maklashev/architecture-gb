namespace ClinicDesctop
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            btnUpdate = new Button();
            listViewClients = new ListView();
            columnHeaderId = new ColumnHeader();
            columnHeaderSurName = new ColumnHeader();
            columnHeaderFirstName = new ColumnHeader();
            columnHeaderPatronymic = new ColumnHeader();
            textBoxSurName = new TextBox();
            textBoxFirstName = new TextBox();
            textBoxPatronymic = new TextBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            textBoxDocument = new TextBox();
            btnAddClient = new Button();
            SuspendLayout();
            // 
            // btnUpdate
            // 
            btnUpdate.BackColor = Color.OrangeRed;
            btnUpdate.Location = new Point(680, 296);
            btnUpdate.Name = "btnUpdate";
            btnUpdate.Size = new Size(108, 30);
            btnUpdate.TabIndex = 0;
            btnUpdate.Text = "Обновить";
            btnUpdate.UseVisualStyleBackColor = false;
            btnUpdate.Click += gbButton_Click;
            // 
            // listViewClients
            // 
            listViewClients.Columns.AddRange(new ColumnHeader[] { columnHeaderId, columnHeaderSurName, columnHeaderFirstName, columnHeaderPatronymic });
            listViewClients.FullRowSelect = true;
            listViewClients.GridLines = true;
            listViewClients.Location = new Point(12, 12);
            listViewClients.MultiSelect = false;
            listViewClients.Name = "listViewClients";
            listViewClients.Size = new Size(776, 278);
            listViewClients.TabIndex = 1;
            listViewClients.UseCompatibleStateImageBehavior = false;
            listViewClients.View = View.Details;
            // 
            // columnHeaderId
            // 
            columnHeaderId.Text = "№";
            // 
            // columnHeaderSurName
            // 
            columnHeaderSurName.Text = "Фамилия";
            columnHeaderSurName.Width = 200;
            // 
            // columnHeaderFirstName
            // 
            columnHeaderFirstName.Text = "Имя";
            columnHeaderFirstName.Width = 200;
            // 
            // columnHeaderPatronymic
            // 
            columnHeaderPatronymic.Text = "Отчество";
            columnHeaderPatronymic.Width = 200;
            // 
            // textBoxSurName
            // 
            textBoxSurName.Location = new Point(197, 334);
            textBoxSurName.Name = "textBoxSurName";
            textBoxSurName.Size = new Size(250, 23);
            textBoxSurName.TabIndex = 2;
            // 
            // textBoxFirstName
            // 
            textBoxFirstName.Location = new Point(197, 363);
            textBoxFirstName.Name = "textBoxFirstName";
            textBoxFirstName.Size = new Size(250, 23);
            textBoxFirstName.TabIndex = 3;
            // 
            // textBoxPatronymic
            // 
            textBoxPatronymic.Location = new Point(197, 392);
            textBoxPatronymic.Name = "textBoxPatronymic";
            textBoxPatronymic.Size = new Size(250, 23);
            textBoxPatronymic.TabIndex = 4;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(122, 337);
            label1.Name = "label1";
            label1.Size = new Size(58, 15);
            label1.TabIndex = 5;
            label1.Text = "Фамилия";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(122, 366);
            label2.Name = "label2";
            label2.Size = new Size(31, 15);
            label2.TabIndex = 6;
            label2.Text = "Имя";           
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(122, 395);
            label3.Name = "label3";
            label3.Size = new Size(58, 15);
            label3.TabIndex = 7;
            label3.Text = "Отчество";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(122, 424);
            label4.Name = "label4";
            label4.Size = new Size(61, 15);
            label4.TabIndex = 9;
            label4.Text = "Документ";            
            // 
            // textBoxDocument
            // 
            textBoxDocument.Location = new Point(197, 421);
            textBoxDocument.Name = "textBoxDocument";
            textBoxDocument.Size = new Size(250, 23);
            textBoxDocument.TabIndex = 8;            
            // 
            // btnAddClient
            // 
            btnAddClient.Location = new Point(486, 416);
            btnAddClient.Name = "btnAddClient";
            btnAddClient.Size = new Size(147, 23);
            btnAddClient.TabIndex = 10;
            btnAddClient.Text = "Добавить клиента";
            btnAddClient.UseVisualStyleBackColor = true;
            btnAddClient.Click += btnAddClientClick;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btnAddClient);
            Controls.Add(label4);
            Controls.Add(textBoxDocument);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(textBoxPatronymic);
            Controls.Add(textBoxFirstName);
            Controls.Add(textBoxSurName);
            Controls.Add(listViewClients);
            Controls.Add(btnUpdate);
            Name = "Form1";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Моя клиника";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btnUpdate;
        private ListView listViewClients;
        private ColumnHeader columnHeaderId;
        private ColumnHeader columnHeaderSurName;
        private ColumnHeader columnHeaderFirstName;
        private ColumnHeader columnHeaderPatronymic;
        private TextBox textBoxSurName;
        private TextBox textBoxFirstName;
        private TextBox textBoxPatronymic;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private TextBox textBoxDocument;
        private Button btnAddClient;
    }
}
