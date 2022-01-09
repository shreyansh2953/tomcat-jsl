
def call()
{
    try{
        node{
                def lib = library 'my-tomcat-library'
                def obj = lib.com.files;
                def myTool = tool 'Terraform'
                def var_file = "${file_name}" 
                  if("${my_choice}"=="apply")
                  {
                     stage("checkout")
                    {
                      def my_git = obj.MyCheckout.new(this);
                      my_git.git_Checkout("${repo_url}")
                    }
                     stage("apply")
                    {
                      def my_apply = obj.Apply.new(this)
                      my_apply.terraform_steps(myTool,"${my_choice}",var_file)

                    }
                  }

                  else
                  {
                      stage("destroy")
                      {
                         def my_destroy = obj.Destroy.new(this)
                         my_destroy.terraform_destroy(myTool,"${my_choice}",var_file)

                      }
                     
                  }
           }
        }

        catch(err)
        {
           println err
        }
    
}