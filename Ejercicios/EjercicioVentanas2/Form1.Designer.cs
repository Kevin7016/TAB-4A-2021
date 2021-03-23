
namespace Ejercicio2
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.button1 = new System.Windows.Forms.Button();
            this.entrada = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.salida = new System.Windows.Forms.TextBox();
            this.clear = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(433, 44);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(107, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "Presioname";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // entrada
            // 
            this.entrada.Location = new System.Drawing.Point(126, 44);
            this.entrada.Name = "entrada";
            this.entrada.Size = new System.Drawing.Size(293, 22);
            this.entrada.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 44);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(108, 17);
            this.label1.TabIndex = 2;
            this.label1.Text = "Introdusca texto";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // salida
            // 
            this.salida.Location = new System.Drawing.Point(24, 103);
            this.salida.Multiline = true;
            this.salida.Name = "salida";
            this.salida.Size = new System.Drawing.Size(525, 288);
            this.salida.TabIndex = 3;
            this.salida.TextChanged += new System.EventHandler(this.salida_TextChanged);
            // 
            // clear
            // 
            this.clear.Location = new System.Drawing.Point(228, 425);
            this.clear.Name = "clear";
            this.clear.Size = new System.Drawing.Size(75, 23);
            this.clear.TabIndex = 4;
            this.clear.Text = "Limpiar";
            this.clear.UseVisualStyleBackColor = true;
            this.clear.Click += new System.EventHandler(this.clear_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(581, 460);
            this.Controls.Add(this.clear);
            this.Controls.Add(this.salida);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.entrada);
            this.Controls.Add(this.button1);
            this.Name = "Form1";
            this.Text = "Sumar";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox entrada;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox salida;
        private System.Windows.Forms.Button clear;
    }
}

